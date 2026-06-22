import java.time.LocalDate;

public record MemberResponse(
        Long id,
        String fullName,
        String email,
        LocalDate dateOfBirth,
        String mobilePhone,
        LocalDate baptismDate
) {}