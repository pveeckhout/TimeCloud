DROP TABLE IF EXISTS [Transfers];
CREATE TABLE [Transfers] (
  [transfer_id] INTEGER NOT NULL ON CONFLICT FAIL PRIMARY KEY ON CONFLICT REPLACE AUTOINCREMENT, 
  [episode_id] INTEGER NOT NULL ON CONFLICT FAIL CONSTRAINT [episode_id] REFERENCES [Episodes]([episode_id]) ON DELETE CASCADE ON UPDATE CASCADE, 
  [transfer_time] DATETIME, 
  [start_department] TEXT, 
  [start_bed] TEXT, 
  [start_medical_department] TEXT, 
  [end_department] TEXT, 
  [end_bed] TEXT, 
  [end_medical_department] TEXT, 
  UNIQUE([episode_id], [transfer_time], [start_department], [start_bed]) ON CONFLICT REPLACE)
;