package kpfu.itis.group907.Economic.Dto;

public class DiagramDto {
    private String category;
    private String countCategory;

    public DiagramDto(String category, String countCategory) {
        this.category = category;
        this.countCategory = countCategory;
    }

    public String getCategory() {
        return category;
    }

    public String getCountCategory() {
        return countCategory;
    }
}
