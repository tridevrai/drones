CREATE TABLE `drones` (
                          `id` BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                          `serial_number` varchar(20) DEFAULT NULL,
                          `model` varchar(20) DEFAULT NULL,
                          `weight_limit` varchar(20) DEFAULT NULL,
                          `battery_capacity` varchar(20) DEFAULT NULL,
                          `state` varchar(20) DEFAULT NULL
);