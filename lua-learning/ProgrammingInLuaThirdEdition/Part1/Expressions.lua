--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2015/12/29
-- Time: 23:49
-- To change this template use File | Settings | File Templates.
--
-- 3.1 Arithmetic Operators

-- Logical Operators
print(4 and 5)  -- 5
print( nil and 13) --nil

print( false and 13) -- false

print(4 or 5) -- 4

print(false or 5) -- 5

local d =  d or "defult" --
print(d)

local a = 10
local b = 13
local max = (a > b) and a or b
print(max)

-- Table Constructors

t = {"name","sex"}
 
for key, v in pairs(t) do
	print("key:"..key.."  value:"..v)
end