package mpww.helper.domain.board.post.model.dto;

public class SearchCondition {
    private String gymName;
    private String content;
    private String order;
    private String direction;

    public SearchCondition(){
    }
    public SearchCondition(String gymName, String content, String order, String direction){
        this.gymName = gymName;
        this.content = content;
        this.order = order;
        this.direction = direction;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "gymName='" + gymName + '\'' +
                ", content='" + content + '\'' +
                ", order='" + order + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
