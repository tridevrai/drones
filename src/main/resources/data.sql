INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
VALUES (1, 'someSerialNumber', 'MIDDLEWEIGHT', 2.50, 10, 'LOADED');

-- negative data that should fail
-- INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
-- VALUES (2, 'someSerialNumfsfsdfsdfsdfsdfsdfsdfsdfsdf24234rwefdsfw23redwssw23refdew234rfew3234refve34gre4t54gtrber', 'MIDDLEWEIGHT', 345.0, 10, 'LOADED');