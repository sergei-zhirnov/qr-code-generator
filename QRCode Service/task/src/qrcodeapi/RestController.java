package qrcodeapi;


import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/api/health")
    public ResponseEntity<?> getHealth() {
        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<?> getQrCode(
            @RequestParam(defaultValue = "250") int size,
            @RequestParam(defaultValue = "png") String type,
            @RequestParam(defaultValue = "L") String correction,
            @RequestParam String contents) {

        List<String> allowedTypes = Arrays.asList("png", "jpeg", "gif", "PNG", "JPEG", "GIF");
        List<String> allowedCorrections = Arrays.asList("L", "M", "Q", "H");


        if (Objects.equals(contents, "") || contents.trim().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiError("Contents cannot be null or blank"));
        } else if (size < 150 || size > 350) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiError("Image size must be between 150 and 350 pixels"));

        } else if (!allowedCorrections.contains(correction)) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiError("Permitted error correction levels are L, M, Q, H"));

        } else if (!allowedTypes.contains(type)) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiError("Only png, jpeg and gif image types are supported"));

        } else {
            BufferedImage bufferedImage = QrGenerator.createQrCode(
                    contents,
                    size,
                    ErrorCorrectionLevel.valueOf(correction));

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.valueOf("image/" + type))
                    .body(bufferedImage);

        }


    }
}