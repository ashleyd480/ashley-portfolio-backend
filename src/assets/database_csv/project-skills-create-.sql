CREATE TABLE Projects (
    project_id SERIAL PRIMARY KEY,
    projectName VARCHAR(255) UNIQUE NOT NULL,
    projectURL TEXT,
    data_completed DATE,
    projectHeaderImage TEXT,
    projectType VARCHAR(255),
    projectBlurb TEXT,
    projectUX TEXT
);

CREATE TABLE Skills (
    skill_id SERIAL PRIMARY KEY,
    skillName VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE ProjectSkills (
    project_id INT,
    skill_id INT,
    PRIMARY KEY (project_id, skill_id),
    FOREIGN KEY (project_id) REFERENCES Projects (project_id),
    FOREIGN KEY (skill_id) REFERENCES Skills (skill_id)
);