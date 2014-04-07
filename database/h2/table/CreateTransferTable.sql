DROP TABLE IF EXISTS Transfers;
CREATE TABLE "Transfers" (
    "transfer_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE ON CONFLICT REPLACE,
    "episode_id" INTEGER REFERENCES "Episode" ("episode_id"),
    "transfer_time" DATETIME,
    "start_department" TEXT,
    "start_bed" TEXT,
    "start_medical_department" TEXT,
    "end_department" TEXT,
    "end_bed" TEXT,
    "end_medical_department" TEXT,
    UNIQUE("episode_id","transfer_time","start_department", "start_bed" ,"end_department", "end_bed")
        ON CONFLICT REPLACE
);