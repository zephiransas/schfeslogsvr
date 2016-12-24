create table live_results (
    id serial primary key,
    song_id int not null,
    song_name varchar(255) null,
    score int not null,
    max_combo int not null,
    prefect int not null,
    great int not null,
    good int not null,
    bad int not null,
    miss int not null,
    created_at timestamp not null default CURRENT_TIMESTAMP
)