DROP TABLE IF EXISTS Episodes;
CREATE TABLE "Episodes" (
    "episode_id" INTEGER PRIMARY KEY NOT NULL UNIQUE,
    "patient_id" TEXT,
    "intake_time" DATETIME,
    "meg" BOOLEAN,
    "triage_time" DATETIME,
    "triage_level" INTEGER,
    UNIQUE("episode_id")
        ON CONFLICT REPLACE
);
