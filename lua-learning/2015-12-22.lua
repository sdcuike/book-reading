--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2015/12/22
-- Time: 21:48
-- To change this template use File | Settings | File Templates.
-- see http://www.tutorialspoint.com/lua/
-- see http://tylerneylon.com/a/learn-lua/

--                       --
--[[ my first program in Lua --]]

print "hello world"

local a = 10
local b = 12
print(a,b)
a,b = b,a
print(a,b)

print(a..b)


function max(a,b)
    if( a > b) then
        return a
    else
        return b
    end

end

print("max of 99, 55 is ",max(99,55))

print(string.lower("DJFJ"))
