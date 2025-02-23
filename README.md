# CSC 1060 Practice 08
The purpose of this practice is to build your skills with the `ArrayList` manipulation and searching methods. 
## A Tale of Two Strings
The theme of this practice is comparing two Strings in order to figure out which words they have in common, which words are unique. You will also implement a similarity metric.

## Task
Implement the `StringComparator` class. The table following illustrates the methods the class contains and what their return values must be. 

### Processing Strings
A `StringComparator` object is created from two `String` objects. The get methods all return `ArrayList<String>`, so you should process the `String` objects into individual words in your constructor. You should write helper methods to break the code down into smaller chunks. All the `ArrayList<String>` objects should contain lower case words, alphabetized, with no duplicates. 

## Usage 
### Some words in common
| Code Segment                                               |            Effect / Return Value      |
| :---                                                       |     :---                              |
| `String a = "The quick red fox";`                         | Sets up a String object                |
| `String b = "jumps over the lazy brown dog";`             | Sets up another String object          |
| `StringComparator sc = new StringComparator(a, b);`| Creates a new `StringComparator` object comparing Strings `a` and `b`. |
| `sc.getString1List()`.                             | Returns the `ArrayList<String>` `[fox, red, quick, the]`, which are the words, lower-case, alphabetized, with no duplicates.|
| `sc.getString2List()`.                             | Returns the `ArrayList<String>` `[brown, dog, jumps, lazy, over, the]` |
| `sc.getCommon()`.                                  | Returns the `ArrayList<String>` `[the]`, which is an alphabetized list of words common to both `String` objects  |
| `sc.getUnique()`.                                  | Returns the `ArrayList<String>` `[brown, dog, fox, jumps, lazy, over, quick, red]`, which is an alphabetized list of words that do not appear in both `String` objects|
| `sc.getSimilarityRatio()`                          | Returns `0.11111111111111`. It is the size of the common list divided by the size of the common list + the unique list. If both `String`s are empty, return `1.0`.|

### Empty Strings
| Code Segment                                               |            Effect / Return Value      |
| :---                                                       |     :---                              |
| `sc = new StringComparator("", "");`               | Creates a `StringComparator` on two empty `String` objects     |
| `sc.getString1List();`                             | Returns an empty `ArrayList<String>`    |
| `sc.getString2List();`                             | Returns an empty `ArrayList<String>`    |
| `sc.getCommon();`                                  | Returns an empty `ArrayList<String>`    |
| `sc.getUnique();`                                  | Returns an empty `ArrayList<String>`    |
| `sc.getSimilarityRatio();`                          | Returns `1.0`    |


### All words in common, just difference in case
| Code Segment                                               |            Effect / Return Value      |
| :---                                                       |     :---                              |
| `String c = "This is the same sentence"`                   | Creates a `String` object     |
| `String d = "THIS IS THE SAME SENTENCES"`                  | Creates a `String` object that is the upper case of the first  |
| `sc = new StringComparator(c, d);`                         | Creates a `StringComparator` on `c` and `d`     |
| `sc.getString1List();`                                     | Returns the `ArrayList<String>` `[is, same, sentence, the, this]` |
| `sc.getString2List();`                                     | Returns the `ArrayList<String>` `[is, same, sentence, the, this]`   |
| `sc.getCommon();`                                          | Returns the `ArrayList<String>` `[is, same, sentence, the, this]`   | 
| `sc.getUnique();`                                           | Returns an empty `ArrayList<String>`    |
| `sc.getSimilarityRatio();`                                  | Returns `1.0`    |

### All words in common, scrambled
| Code Segment                                               |            Effect / Return Value      |
| :---                                                       |     :---                              |
| `String e = "A man is not merely a beast"`                   | Creates a `String` object     |
| `String f = "A beast is not merely a man"`                  | Creates a `String` object has the same words but scrambled |
| `sc = new StringComparator(e, f);`                         | Creates a `StringComparator` on `e` and `f`     |
| `sc.getString1List();`                                     | Returns the `ArrayList<String>` `[a, beast, is, man, merely, not]` |
| `sc.getString2List();`                                     | Returns the `ArrayList<String>` `[a, beast, is, man, merely, not]`   |
| `sc.getCommon();`                                          | Returns the `ArrayList<String>` `[a, beast, is, man, merely, not]`   | 
| `sc.getUnique();`                                           | Returns an empty `ArrayList<String>`    |
| `sc.getSimilarityRatio();`                                  | Returns `1.0`    |


### Useful methods
| Code Segment                                               |            Effect / Return Value       |
| :---                                                       |     :---                               |
| `a.split(" ");`                                            | Splits a `String` on the space. Returns an array of `String` objects that are the individual words. Does not work well on empty an `String`, so you should make that a special case. `"The quick red fox"` becomes `{"The", "quick", "red", "fox"}`.|
| `a.toLowerCase();`                                           | Returns a lower case version of the `String` object|
| `a.compareTo(b);`                                            | Returns `0` if they're equal, a negative value if `a` comes before `b` alphabetically, and a positive value if `a` comes after `b` alphabetically. |
| `Collections.sort(alist);`   | Sorts `alist` alphabetically. You need to import `java.util.Collections`|

## Unit Tests
Ensure that the unit tests pass by running the unit test files in `src/test/java/`. 

## AI Warning
If you feed this into AI, it will use structures you are not familiar with. Just do this assignment yourself. 