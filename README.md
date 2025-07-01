```markdown
# SuperDeal E-commerce Payment System

## Project Overview
A dual-system e-commerce and payment platform built on **SpringBoot**, featuring:
- **Databases**: MySQL (primary data) + Redis (caching/queues)
- **Messaging**: RabbitMQ (message broker)
- **Core Modules**:  
  ✔️ User registration/login  
  ✔️ Shopping cart management  
  ✔️ Flash sale (panic buying)  
  ✔️ Order payment processing  

## Technical Highlights
### 🕒 Order Timeout Automation
- Implemented auto-cancel for unpaid orders using **Redis Sorted Sets** + **Lua scripts**  
- Ensures timely resource release and inventory rollback

### 🛒 High-Performance Shopping Cart
- Stored cart data in **Redis** to handle high-frequency read/write requests  
- Reduced MySQL load by 40%+ during peak traffic

### ⚡ Flash Sale Concurrency Control
1. **Over-Selling Prevention**:  
   - Solved inventory overselling via **optimistic locking** during order creation
2. **Anti-Abuse Mechanism**:  
   - Enforced "one order per user" with **Redisson distributed locks**

### 🔁 Cache Consistency Strategy
- Cached high-frequency data (e.g., product info) in Redis  
- Guaranteed data integrity with **"Update DB → Invalidate Cache"** approach  
- Eliminated stale cache risks through proactive deletion

## Development Period
October 2024 – May 2025
```
