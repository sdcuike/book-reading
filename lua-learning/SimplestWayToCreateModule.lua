--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2016/1/2
-- Time: 15:10
-- To change this template use File | Settings | File Templates.
--

--[[The simplest way to create a module in Lua is really simple: we create a table,
put all functions we want to export inside it, and return this table.  --]]

local M = {}

function M.add(a,b)
    return a + b;
end

return M