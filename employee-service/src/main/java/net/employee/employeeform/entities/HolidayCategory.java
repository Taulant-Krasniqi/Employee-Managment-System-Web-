package net.employee.employeeform.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "holiday_category", schema = "employee_data", catalog = "")
public class HolidayCategory {
    private int categoryId;
    private String categoryName;
    private int categoryDays;

    @Id
    @Column(name = "CategoryID", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "Category_Name", nullable = false, length = 255)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "Category_Days", nullable = false)
    public int getCategoryDays() {
        return categoryDays;
    }

    public void setCategoryDays(int categoryDays) {
        this.categoryDays = categoryDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HolidayCategory that = (HolidayCategory) o;
        return categoryId == that.categoryId &&
                categoryDays == that.categoryDays &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryDays);
    }
}
