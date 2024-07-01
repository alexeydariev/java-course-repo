DROP database "test_data_db";
CREATE database "test_data_db";
CREATE TABLE charge_test_data (
    id INTEGER PRIMARY KEY,
    charge_input INTEGER NOT NULL,
    charge_expected INTEGER NOT NULL,
);


