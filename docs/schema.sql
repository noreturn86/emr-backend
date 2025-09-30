-- Patients table
CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    health_card_number VARCHAR(50) UNIQUE NOT NULL,
    sex VARCHAR(20)
);

-- Medical conditions
CREATE TABLE medical_conditions (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    condition_name VARCHAR(255) NOT NULL
);

-- Allergies
CREATE TABLE allergies (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    information VARCHAR(255) NOT NULL
);

-- Medications
CREATE TABLE medications (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    prescription VARCHAR(255) NOT NULL
);

-- Lab results
CREATE TABLE lab_results (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    test_date DATE NOT NULL,
    test_type VARCHAR(255) NOT NULL,
    result_value VARCHAR(100) NOT NULL,
    units VARCHAR(50)
);

-- Providers
CREATE TABLE providers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    credential VARCHAR(50)
);

-- Encounters
CREATE TABLE encounters (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    provider_id INT REFERENCES providers(id) ON DELETE SET NULL,
    encounter_date TIMESTAMP NOT NULL,
    summary TEXT
);

-- Consultant letters
CREATE TABLE consultant_letters (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    letter_date DATE NOT NULL,
    specialist_type VARCHAR(100) NOT NULL,
    summary TEXT
);

-- Test reports
CREATE TABLE test_reports (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    report_date DATE NOT NULL,
    test_type VARCHAR(100) NOT NULL,
    summary TEXT
);
