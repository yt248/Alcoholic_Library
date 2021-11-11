create table brandies
(
    id                    bigint not null auto_increment,
    alcohol_volume        double precision,
    bottle_volume         double precision,
    classification_brandy varchar(255),
    product_category      varchar(255),
    years_old             integer,
    brand_id              bigint,
    country_id            bigint,
    manufacturer_id       bigint,
    region_id             bigint,
    primary key (id)
) engine = InnoDB;
create table brands
(
    id              bigint not null auto_increment,
    name            varchar(255),
    manufacturer_id bigint,
    primary key (id)
) engine = InnoDB;
create table cognacs
(
    id                    bigint not null auto_increment,
    alcohol_volume        double precision,
    bottle_volume         double precision,
    classification_cognac varchar(255),
    product_category      varchar(255),
    years_old             integer,
    brand_id              bigint,
    country_id            bigint,
    manufacturer_id       bigint,
    region_id             bigint,
    primary key (id)
) engine = InnoDB;
create table countries
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table manufacturers
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table regions
(
    id         bigint not null auto_increment,
    name       varchar(255),
    country_id bigint,
    primary key (id)
) engine = InnoDB;
create table subregions
(
    id        bigint not null auto_increment,
    name      varchar(255),
    region_id bigint,
    primary key (id)
) engine = InnoDB;
alter table brandies
    add constraint FKcboudwi2xpdsc6chn9fl0jynd foreign key (brand_id) references brands (id);
alter table brandies
    add constraint FKl8i2f9kl2790nijqsks4t12mj foreign key (country_id) references countries (id);
alter table brandies
    add constraint FKk0alxaln673u1ovetwkcdi0r0 foreign key (manufacturer_id) references manufacturers (id);
alter table brandies
    add constraint FKj06q2j1qhxdqbfdkvlvfb2uao foreign key (region_id) references regions (id);
alter table brands
    add constraint FK1oagn14j3x77e9cjj4na2d0n6 foreign key (manufacturer_id) references manufacturers (id);
alter table cognacs
    add constraint FKkm03wr0ooju6sov44l5gg2v3v foreign key (brand_id) references brands (id);
alter table cognacs
    add constraint FK1pnrcw97j3u4htog2g1gjc7r4 foreign key (country_id) references countries (id);
alter table cognacs
    add constraint FKic9ukl740kdl09psc78h4h6fo foreign key (manufacturer_id) references manufacturers (id);
alter table cognacs
    add constraint FKccq5p0jwy656y5quvvu0goack foreign key (region_id) references regions (id);
alter table regions
    add constraint FK2x36ly3wpe3l83kh32211kwf3 foreign key (country_id) references countries (id);
alter table subregions
    add constraint FKq3dee1lcfkumueexvxvhxbdjl foreign key (region_id) references regions (id);