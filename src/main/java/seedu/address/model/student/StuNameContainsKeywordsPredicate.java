package seedu.address.model.student;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.student.Student;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class StuNameContainsKeywordsPredicate implements Predicate<Student> {
    private final List<String> keywords;

    public StuNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Student student) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(student.getName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.student.StuNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((seedu.address.model.student.StuNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}

