--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2015/12/29
-- Time: 21:48
-- To change this template use File | Settings | File Templates.
--

print("hello word")

print("hello")

-- defines a factorial function
function fact(n)
    if n == 0 or n == 1 then
        return 1
    end

    return n * fact(n - 1)
end


print(fact(3))

print("input a number")

-- reads a number
--[[
   学习lua
   多行注释
 --]]




-- 1.3 Global Variables
print(b)
b = 10
print(b)

b = nil
print(b)


number = io.read("*n")
print(fact(number))