--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2016/1/2
-- Time: 10:48
-- To change this template use File | Settings | File Templates.
--
t = {}
print(getmetatable(t))  --nil

tm = {}
setmetatable(t,tm)
print(getmetatable(t) == tm)  --nil

-- Arithmetic Metamethods
