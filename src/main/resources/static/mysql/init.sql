-- Create a new database
CREATE DATABASE IF NOT EXISTS agentai_db;

-- Switch to the new database
USE agentai_db;

create table agentai_db.assessments
(
    assessment_id    varchar(36) not null
        primary key,
    user_id          varchar(36) null,
    skill_id         varchar(36) null,
    assessor_type    text        null,
    assessor_user_id varchar(36) null,
    score            smallint    not null,
    assessed_at      timestamp   not null
);

create index idx_assessments_user_skill_time
    on agentai_db.assessments (user_id asc, skill_id asc, assessed_at desc);

create table agentai_db.career_preferences
(
    user_id    varchar(36)                         not null
        primary key,
    preference text                                null,
    notes      text                                null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table agentai_db.employee_performance
(
    employee_id            int auto_increment
        primary key,
    employee_name          varchar(255)                        not null,
    actions_items_pendings text                                null,
    goals_closed           text                                null,
    current_open_goals     text                                null,
    created_at             timestamp default CURRENT_TIMESTAMP not null
);

create table agentai_db.employee_profiles
(
    employee_id                 varchar(255) not null
        primary key,
    first_name                  varchar(255) null,
    last_name                   varchar(255) null,
    email                       varchar(255) null,
    current_role                varchar(255) null,
    target_role                 varchar(255) null,
    personal_values             text         null,
    career_preferences          text         null,
    communication_self          int          null,
    communication_peer          int          null,
    communication_manager       int          null,
    leadership_self             int          null,
    leadership_peer             int          null,
    leadership_manager          int          null,
    technical_expertise_self    int          null,
    technical_expertise_peer    int          null,
    technical_expertise_manager int          null,
    project_management_self     int          null,
    project_management_peer     int          null,
    project_management_manager  int          null,
    analytical_thinking_self    int          null,
    analytical_thinking_peer    int          null,
    analytical_thinking_manager int          null,
    collaboration_self          int          null,
    collaboration_peer          int          null,
    collaboration_manager       int          null,
    creativity_self             int          null,
    creativity_peer             int          null,
    creativity_manager          int          null,
    problem_solving_self        int          null,
    problem_solving_peer        int          null,
    problem_solving_manager     int          null,
    adaptability_self           int          null,
    adaptability_peer           int          null,
    adaptability_manager        int          null,
    time_management_self        int          null,
    time_management_peer        int          null,
    time_management_manager     int          null,
    gigs                        text         null,
    mentors                     text         null,
    learning_content            text         null,
    check ((`communication_self` >= 1) and (`communication_self` <= 5)),
    check ((`project_management_self` >= 1) and (`project_management_self` <= 5)),
    check ((`project_management_peer` >= 1) and (`project_management_peer` <= 5)),
    check ((`project_management_manager` >= 1) and (`project_management_manager` <= 5)),
    check ((`analytical_thinking_self` >= 1) and (`analytical_thinking_self` <= 5)),
    check ((`analytical_thinking_peer` >= 1) and (`analytical_thinking_peer` <= 5)),
    check ((`analytical_thinking_manager` >= 1) and (`analytical_thinking_manager` <= 5)),
    check ((`collaboration_self` >= 1) and (`collaboration_self` <= 5)),
    check ((`collaboration_peer` >= 1) and (`collaboration_peer` <= 5)),
    check ((`collaboration_manager` >= 1) and (`collaboration_manager` <= 5)),
    check ((`creativity_self` >= 1) and (`creativity_self` <= 5)),
    check ((`communication_peer` >= 1) and (`communication_peer` <= 5)),
    check ((`creativity_peer` >= 1) and (`creativity_peer` <= 5)),
    check ((`creativity_manager` >= 1) and (`creativity_manager` <= 5)),
    check ((`problem_solving_self` >= 1) and (`problem_solving_self` <= 5)),
    check ((`problem_solving_peer` >= 1) and (`problem_solving_peer` <= 5)),
    check ((`problem_solving_manager` >= 1) and (`problem_solving_manager` <= 5)),
    check ((`adaptability_self` >= 1) and (`adaptability_self` <= 5)),
    check ((`adaptability_peer` >= 1) and (`adaptability_peer` <= 5)),
    check ((`adaptability_manager` >= 1) and (`adaptability_manager` <= 5)),
    check ((`time_management_self` >= 1) and (`time_management_self` <= 5)),
    check ((`time_management_peer` >= 1) and (`time_management_peer` <= 5)),
    check ((`communication_manager` >= 1) and (`communication_manager` <= 5)),
    check ((`time_management_manager` >= 1) and (`time_management_manager` <= 5)),
    check ((`leadership_self` >= 1) and (`leadership_self` <= 5)),
    check ((`leadership_peer` >= 1) and (`leadership_peer` <= 5)),
    check ((`leadership_manager` >= 1) and (`leadership_manager` <= 5)),
    check ((`technical_expertise_self` >= 1) and (`technical_expertise_self` <= 5)),
    check ((`technical_expertise_peer` >= 1) and (`technical_expertise_peer` <= 5)),
    check ((`technical_expertise_manager` >= 1) and (`technical_expertise_manager` <= 5))
);

create table agentai_db.gig_skills
(
    gig_id       varchar(36) not null,
    skill_id     varchar(36) not null,
    impact_level text        null,
    notes        text        null,
    primary key (gig_id, skill_id)
);

create table agentai_db.gigs
(
    gig_id              varchar(36) not null
        primary key,
    title               text        not null,
    description         text        null,
    department          text        null,
    location            text        null,
    url                 text        null,
    start_date          date        null,
    end_date            date        null,
    time_commitment_pct smallint    null,
    owner_user_id       varchar(36) null
);

create table agentai_db.learning_content
(
    learning_id      varchar(36) not null
        primary key,
    title            text        not null,
    provider         text        null,
    content_type     text        null,
    url              text        null,
    duration_minutes int         null,
    level            text        null,
    description      text        null
);

create table agentai_db.learning_skills
(
    learning_id   varchar(36) not null,
    skill_id      varchar(36) not null,
    outcome_level text        null,
    notes         text        null,
    primary key (learning_id, skill_id)
);

create table agentai_db.mentor_skills
(
    mentor_id  varchar(36) not null,
    skill_id   varchar(36) not null,
    focus_area text        null,
    notes      text        null,
    primary key (mentor_id, skill_id)
);

create table agentai_db.mentors
(
    mentor_id          varchar(36) not null
        primary key,
    mentor_name        text        not null,
    mentor_email       text        null,
    internal_user_id   varchar(36) null,
    bio                text        null,
    availability_notes text        null,
    url                text        null
);

create table agentai_db.role_skill_requirements
(
    role_id              varchar(36) not null,
    skill_id             varchar(36) not null,
    required_proficiency smallint    null,
    weighting            decimal     null,
    primary key (role_id, skill_id),
    check (`required_proficiency` between 1 and 5)
);

create table agentai_db.role_skills
(
    role_id              char(36)      not null,
    skill_id             char(36)      not null,
    required_proficiency int           not null,
    weighting            decimal(5, 4) not null,
    primary key (role_id, skill_id)
);

create table agentai_db.roles
(
    role_id     varchar(36)                         not null
        primary key,
    role_name   text                                not null,
    role_family text                                null,
    description text                                null,
    created_at  timestamp default CURRENT_TIMESTAMP null
);

create table agentai_db.skills
(
    skill_id       varchar(36) not null
        primary key,
    skill_name     text        not null,
    skill_category text        null,
    description    text        null
);

create table agentai_db.user_opportunity_engagements
(
    engagement_id    varchar(36) not null
        primary key,
    user_id          varchar(36) null,
    opportunity_type text        null,
    opportunity_id   varchar(36) not null,
    status           text        null,
    started_at       timestamp   null,
    completed_at     timestamp   null,
    hours_spent      decimal     null,
    notes            text        null
);

create table agentai_db.user_role_priorities
(
    user_id    char(36)  not null,
    role_id    char(36)  not null,
    priority   int       not null,
    notes      text      null,
    updated_at timestamp not null
);

create table agentai_db.user_roles
(
    user_id    varchar(36)          not null,
    role_id    varchar(36)          not null,
    start_date date                 not null,
    end_date   date                 null,
    is_current tinyint(1) default 0 null,
    primary key (user_id, role_id, start_date)
);

create table agentai_db.user_target_roles
(
    user_id    varchar(36)                         not null,
    role_id    varchar(36)                         not null,
    priority   smallint                            null,
    notes      text                                null,
    updated_at timestamp default CURRENT_TIMESTAMP null,
    primary key (user_id, role_id)
);

create table agentai_db.user_values
(
    user_id  varchar(36) not null,
    value_id varchar(36) not null,
    priority smallint    null,
    primary key (user_id, value_id)
);

create table agentai_db.users
(
    user_id    varchar(36)                         not null
        primary key,
    first_name text                                not null,
    last_name  text                                not null,
    email      text                                not null,
    status     text                                not null,
    created_at timestamp default CURRENT_TIMESTAMP null
);

create table agentai_db.`values`
(
    value_id    varchar(36) not null
        primary key,
    value_name  text        not null,
    description text        null
);

