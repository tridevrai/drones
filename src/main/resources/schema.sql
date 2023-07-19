CREATE TABLE `drones` (
                          `id` BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                          `serial_number` varchar(100) NOT NULL,
                          `model` varchar(20) NOT NULL,
                          `weight_limit` DECIMAL(6 , 3) NOT NULL,
                          `battery_capacity` INT(3) NOT NULL,
                          `state` varchar(20) NOT NULL
);