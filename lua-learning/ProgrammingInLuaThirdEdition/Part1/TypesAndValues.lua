--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2015/12/29
-- Time: 22:46
-- To change this template use File | Settings | File Templates.
--


--[[
 Lua is a dynamically typed language. There are no type definitions in the
language; each value carries its own type.
There are eight basic types in Lua: nil, boolean, number, string, userdata,
function, thread, and table. The type function gives the type name of any given
value:
--]]

print(type("Hello world")) --string
print(type(10.4*3))    --  number

print(type(print)) -- function

print(type(type)) -- function

print(type(true)) -- boolean

print(type(nil)) -- nil

print(type(type(x))) -- string
--[[The last line will result in “string” no matter the value of X, because the result
of type is always a string. --]]

print("Variables have no predefined types; any variable can contain values of any  type:")
print(type(a))  -- nil

a = 10
print(type(a))  --  number

a = "a string"

print(type(a))  -- string

a = print  -- yes,this is valid
--[[ Notice the last two lines: functions are first-class values in Lua; so, we can
manipulate them like any other value. (We will see more about this facility in
Chapter 6.)  --]]

a(type(a)) -- function

a= "hello"
print(#a)

print("Coercions")

print("10" + 1) -- 11
print("10 + 1")
print(10 .. 100)

print("If you need to convert a string to a number explicitly, you can use the function tonumber, which returns nil if the string does not denote a proper number")

n = tonumber("100")
if n == nil then
    error("is not a valid number")
 else
    print(n)
end


--2.5 Tables
print("2.5 Tables")

a = {}
k = "x"
a[k] = 10
print(a["x"])

a[20] = "great"
k = 20
print(a[k])