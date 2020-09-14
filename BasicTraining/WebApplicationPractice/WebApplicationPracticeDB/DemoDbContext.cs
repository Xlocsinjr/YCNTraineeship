using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebApplicationPracticeDB
{
    class DemoDbContext : DbContext
    {
        public DbSet<Adress> Adresses { get; set; }
    }
}
