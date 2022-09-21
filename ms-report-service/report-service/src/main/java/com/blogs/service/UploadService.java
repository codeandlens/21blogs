package com.blogs.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.blogs.entity.AffectedBooking;
import com.blogs.entity.BookingBackup;
import com.blogs.entity.Doctor;
import com.blogs.entity.DoctorBranch;
import com.blogs.entity.ExceptionTimeTable;
import com.blogs.entity.StgBookingBackup;
import com.blogs.entity.StgEffort;
import com.blogs.entity.StgLeave;
import com.blogs.entity.StgScheduler;
import com.blogs.entity.StgStandard;
import com.blogs.entity.StgStandardDetail;
import com.blogs.entity.StgValidTimeTable;

public interface UploadService {

    public void truncateStdExplain();
    public void saveStdExplain(StgStandard std);
    public void truncateStgLeave();
    public void saveStgLeave(StgLeave std);
    public void saveStgLeaves(List<StgLeave> stds);
    public void truncateStgEffort();
    public void saveStgEffort(StgEffort std);
    public void saveStgEffort(List<StgEffort> stds);
    public void truncateStdDetail();
    public Doctor mapDoctorForExcel(String rawDoctorStr, List<Doctor> doctors);
    public void saveStdDetail(StgStandardDetail stdd);
    public List<StgStandard> getDataFromStandardExplain();
    public List<StgStandardDetail> getDataFromStandardDetail();
    public void trancateStgValidTimeTable();
    public void saveStgValidTimeTable(StgValidTimeTable stg);
    public void truncateStgScheduler();
    public List<String> findYearOnStandExplain();
    public List<Integer> listDoctorId();
    public Map<String,Date> findMinMaxOfYear(String year);
    public void saveStgScheduler(StgScheduler stg);
    public String findSchedulerId(Date thisDate);
    public List<StgLeave> getStgLeaves();
//    public List<StandardExplain> getStandardExplain();
//    public List<StandardExplain> findStandardExplainSlot(Date selectedDate,Integer doctorId);
    public List<StgValidTimeTable> findAffectiveSlot(Date selectedDate,Integer doctorId);
    public void removeValidTime(StgValidTimeTable stg);
    public List<StgValidTimeTable> findAllStgValidTimeTable();
    public List<StgEffort> findAllStgEffort();
    public List<StgScheduler> findAllStgScheduler();
    public List<StgStandard> findAllStgStandardExplain();
    public List<StgStandardDetail> findAllStgStandardDetail();
//    public void trancateStandardExplain();
//    public void saveStandardExplain(List<StandardExplain> standardExplainList);
//    public void saveStandardExplain(StandardExplain standardExplain);
    public List<DoctorBranch> findDoctorBranchStgValidTimeTable();
    public List<StgValidTimeTable> getStgValidTimeTableWithOutNoti(Date currentDate);
    public List<AffectedBooking> getAffectedBooking();
    public List<StgBookingBackup> getStgBackUp();
    public void saveAllExceptionTimeTable(List<ExceptionTimeTable> exceptionTimeTableList);
    public void saveExceptionTimeTable(ExceptionTimeTable exceptionTimeTableList);
    public void trancateExceptionTimeTable();
    public void saveAllBookingBackup(List<BookingBackup> bookingBackupList);
    public void removeListValidTime(List<StgValidTimeTable> stgList);
    
}
