create table if not exists storage (
    id bigint identity primary key,
    file_name varchar(255),
    content_type varchar(255),
    data binary
);