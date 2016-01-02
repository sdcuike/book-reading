--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2016/1/2
-- Time: 11:19
-- To change this template use File | Settings | File Templates.
--

--[[ Some people do not like the final return statement. One way of eliminating
it is to assign the module table directly into package.loaded:  --]]

local M = {}

package.loaded[...] = M

function M.add(a,b)
    return a + b
end

