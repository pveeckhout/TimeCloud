INSERT INTO [Requests] (
    [request_id],
    [patient_id],
    [episode_id],
    [intake_kind],
    [intake_time],
    [start_department],
    [start_medical_department],
    [request_time],
    [response_time],
    [transfer_time],
    [intake_date],
    [own_department]
) values (?,?,?,?,?,?,?,?,?,?,?,?);