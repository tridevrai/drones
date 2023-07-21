INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
VALUES (1, 'someSerialNumber', 'MIDDLEWEIGHT', 2.50, 10, 'LOADED');

-- Begin Loading initial data for medicine
INSERT INTO medications(id, name, weight, code, image)
VALUES (1, 'name1', 40.56, 'code1', 1234);
INSERT INTO medications(id, name, weight, code, image)
VALUES (2, 'med_with_500_weight', 500.0, 'code2', 2354);
INSERT INTO medications(id, name, weight, code, image)
VALUES (3, 'name3', 100.67, 'code3', 2345);
-- End Loading initial data for medicine


INSERT INTO load(id, drone_id, medication_id, load_reference_id)
VALUES (1, 1, 1, 'someLoadReferenceId');


-- negative data that should fail
-- INSERT INTO drones(id, serial_number, model, weight_limit, battery_capacity, state)
-- VALUES (2, 'someSerialNumfsfsdfsdfsdfsdfsdfsdfsdfsdf24234rwefdsfw23redwssw23refdew234rfew3234refve34gre4t54gtrber', 'MIDDLEWEIGHT', 345.0, 10, 'LOADED');