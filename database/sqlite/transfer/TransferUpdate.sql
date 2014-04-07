UPDATE Transfers
SET
    transfer_id = ?,
    transfer_time = ?,
    start_department = ?,
    start_bed = ?,
    start_medical_department = ?,
    end_bed = ?,
    end_department = ?
    end_bed = ?,
    end_medical_department = ?
WHERE 1 = 1
    AND transfer_id = ?
;
    