package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignManager;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String projectDetails;
    private Status projectStatus;

    private int completeTaskCount;
    private int unfinishedTaskCounts;

    public ProjectDTO(String projectName, String projectCode, UserDTO assignManager, LocalDate startDate, LocalDate endDate, String projectDetails, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignManager = assignManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetails = projectDetails;
        this.projectStatus = projectStatus;
    }
}
