-- cleanup_and_reseed.sql
-- Script B: CLEANUP test users (email like %@example.com) and reseed identity.
-- Run this if you want to remove previous test users and reset identity for a clean run.

SET NOCOUNT ON;

-- Delete hobbies rows for test users
DELETE uh
FROM dbo.user_hobbies uh
JOIN dbo.users u ON uh.user_id = u.id
WHERE u.email LIKE '%@example.com';

-- Delete test users
DELETE FROM dbo.users WHERE email LIKE '%@example.com';

-- Reseed identity to current max(id) (or 0 if empty)
DECLARE @maxid INT;
SELECT @maxid = ISNULL(MAX(id), 0) FROM dbo.users;
-- set next identity value to @maxid (so next insert will be @maxid + 1)
DBCC CHECKIDENT ('dbo.users', RESEED, @maxid);

PRINT 'Cleanup done. identity reseeded to ' + CAST(@maxid AS VARCHAR(20));
