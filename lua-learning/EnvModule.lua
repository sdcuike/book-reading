--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2016/1/2
-- Time: 15:38
-- To change this template use File | Settings | File Templates.
--

--[[ One drawback of those basic methods for creating modules is that it is all too
easy to pollute the global space, for instance by forgetting a local in a private
declaration.
Environments offer an interesting technique for creating modules that solves
this problem. Once the module main chunk has an exclusive environment, not
only all its functions share this table, but also all its global variables go to this
table. Therefore, we can declare all public functions as global variables and they
will go to a separate table automatically. All the module has to do is to assign
this table to the _ENV variable.  --]]
local M = {}
_ENV = M

function add(a,b)
    return a + b
end
return M

