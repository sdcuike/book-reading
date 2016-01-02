--
-- Created by IntelliJ IDEA.
-- User: sdcuike
-- Date: 2016/1/2
-- Time: 16:07
-- To change this template use File | Settings | File Templates.
--

Account = {
    balance = 0,
    withdraw = function(self,v)
        self.balance = self.balance - v
    end
}

function Account:deposit(v)
    self.balance = self.balance + v
end


function Account:new(o)
    o = o or {}
    setmetatable(o,self)
    self.__index = self
    return o
end
print(Account.balance)  --0
Account.deposit(Account,200.00)
print(Account.balance) --200

Account:withdraw(100.00)
print(Account.balance) --100


print("a new ")
local a = Account:new()
local b = Account:new()
print("a:"..a.balance)
a:deposit(100)
print("a:"..a.balance)
print("b:"..b.balance)
