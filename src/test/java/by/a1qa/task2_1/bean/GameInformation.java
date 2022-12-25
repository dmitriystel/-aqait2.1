package by.a1qa.task2_1.bean;

import lombok.*;

/*
Code review 24.12.2022
1st comment: Class fields must have access modifiers. To limit the scope properly
Theory:
JavaBeans: part of the basic requirements for Bean component classes
- fields must be encapsulated;
- getters and setters must be used to access fields

fixed: fields are private

2nd comment:
constructor and some of the getters/setters are not used anywhere.
You don't want to clog the project with unused code. For convenient work with models, I recommend using lombok

fixed:lombok used
*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

//
//@Data
//@Builder
public class GameInformation {
    private String title;
    private Platform platform;
    private String releaseDate;
    private String reviewSummaryResult;
    private String price;

//    public GameInformation(String title, Platform platform, String releaseDate, String reviewSummaryResult, String price){
//        this.title = title;
//        this.platform = platform;
//        this.releaseDate = releaseDate;
//        this.reviewSummaryResult = reviewSummaryResult;
//        this.price = price;
//    }

}
/*
   private String windows;
    private String macOS;
    private String steamOS;
    private String remixeMusic;
 */