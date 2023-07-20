INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
VALUES (1, 'someSerialNumber', 'MIDDLEWEIGHT', 2.50, 10, 'LOADED');


INSERT INTO medications( id,name, weight, code, image)
VALUES ( 1,'SomeName', 40.56, 'SOMECODE', 1234);


INSERT INTO load( id,drone_id, medication_id, load_reference_id, status)
VALUES ( 1,1,1, 'someLoadReferenceId', 'START');


-- negative data that should fail
-- INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
-- VALUES (2, 'someSerialNumfsfsdfsdfsdfsdfsdfsdfsdfsdf24234rwefdsfw23redwssw23refdew234rfew3234refve34gre4t54gtrber', 'MIDDLEWEIGHT', 345.0, 10, 'LOADED');