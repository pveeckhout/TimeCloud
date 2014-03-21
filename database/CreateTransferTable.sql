CREATE TABLE "Transfer" (
    "transfer_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    "episode_id" INTEGER REFERENCES "Episode" ("episode_id"),
    "transfer_time" DATE,
    "start_department" TEXT,
    "start_bed" TEXT,
    "start_medical_department" TEXT,
    "end_department" TEXT,
    "end_bed" TEXT,
    "end_medical_department" TEXT,
    UNIQUE("episode_id","transfer_time","start_department", "end_department")
        ON CONFLICT REPLACE
)