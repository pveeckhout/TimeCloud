DROP TABLE IF EXISTS Episodes;
CREATE TABLE "Episodes" (
    "episode_id" INTEGER PRIMARY KEY NOT NULL UNIQUE,
    "patient_id" TEXT,
    "intake_time" DATE,
    "meg" BOOLEAN,
    "triage_time" DATE,
    "triage_level" INTEGER
);
