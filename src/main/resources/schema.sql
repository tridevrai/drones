CREATE TABLE `drones` (
                          `id` BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY AUTO_INCREMENT,
                          `serial_number` varchar(100) NOT NULL,
                          `model` varchar(20) NOT NULL,
                          `weight_limit` DECIMAL(6 , 3) NOT NULL,
                          `battery_capacity` INT(3) NOT NULL,
                          `state` varchar(20) NOT NULL,
                          created_date TIMESTAMP,
                          last_modified_date TIMESTAMP
);

CREATE TABLE `medications` (
                            id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(200) NOT NULL,
                            weight DECIMAL(10,2) NOT NULL,
                            code VARCHAR(100) NOT NULL,
                            image BLOB NOT NULL,
                            created_date TIMESTAMP,
                            last_modified_date TIMESTAMP
);

CREATE TABLE `load` (
                        id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY AUTO_INCREMENT,
                        drone_id BIGINT NOT NULL,
                        medication_id BIGINT NOT NULL,
                        load_reference_id VARCHAR(255) NOT NULL,
                        status VARCHAR(255) NOT NULL,
                        created_date TIMESTAMP,
                        last_modified_date TIMESTAMP
);