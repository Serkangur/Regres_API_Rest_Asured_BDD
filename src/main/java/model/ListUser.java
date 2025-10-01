package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class ListUser {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserData> data; // data array
    private Support support; // support objesi



    @Data
    @NoArgsConstructor
    public static class UserData {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    @NoArgsConstructor
    public static class Support {
        private String url;
        private String text;
    }
}
