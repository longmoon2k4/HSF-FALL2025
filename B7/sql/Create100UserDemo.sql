-- seed_100_users_safe.sql
-- Script A: Insert 100 users safely (no explicit IDs); skip when email exists.
-- Run in SSMS while connected to the target database (e.g., tutorial) or via sqlcmd.

SET NOCOUNT ON;
SET DATEFORMAT ymd;

DECLARE @i INT = 1;
WHILE @i <= 100
BEGIN
    DECLARE @email NVARCHAR(100) = 'user' + RIGHT('000' + CAST(@i AS VARCHAR(3)), 3) + '@example.com';
    -- Skip if email already exists
    IF NOT EXISTS (SELECT 1 FROM dbo.users WHERE email = @email)
    BEGIN
        DECLARE @first_name NVARCHAR(100) = 'User' + CAST(@i AS VARCHAR(3));
        DECLARE @last_name NVARCHAR(100) = 'Test';
        DECLARE @password NVARCHAR(200) = 'password'; -- demo only
        DECLARE @gender NVARCHAR(10) = CASE WHEN (@i % 2) = 0 THEN 'female' ELSE 'male' END;
        DECLARE @province NVARCHAR(100) = CASE WHEN (@i % 4) = 1 THEN 'Ha Noi Capital' WHEN (@i % 4) = 2 THEN 'Ho Chi Minh City' WHEN (@i % 4) = 3 THEN 'Da Nang City' ELSE 'Can Tho City' END;
        DECLARE @birthday DATE = DATEADD(DAY, @i, '1990-01-01');

        INSERT INTO dbo.users (birthday, email, first_name, last_name, password, gender, province)
        VALUES (@birthday, @email, @first_name, @last_name, @password, @gender, @province);

        DECLARE @newid INT = SCOPE_IDENTITY();

        -- Insert hobbies safely (avoid duplicates)
        IF NOT EXISTS (SELECT 1 FROM dbo.user_hobbies WHERE user_id = @newid AND hobby = 'reading')
            INSERT INTO dbo.user_hobbies (user_id, hobby) VALUES (@newid, 'reading');

        IF (@i % 2) = 0
            IF NOT EXISTS (SELECT 1 FROM dbo.user_hobbies WHERE user_id = @newid AND hobby = 'music')
                INSERT INTO dbo.user_hobbies (user_id, hobby) VALUES (@newid, 'music');

        IF (@i % 3) = 0
            IF NOT EXISTS (SELECT 1 FROM dbo.user_hobbies WHERE user_id = @newid AND hobby = 'travel')
                INSERT INTO dbo.user_hobbies (user_id, hobby) VALUES (@newid, 'travel');
    END
    ELSE
    BEGIN
        PRINT 'Skipped existing email: ' + @email;
    END

    SET @i = @i + 1;
END

PRINT 'Script A finished.';
