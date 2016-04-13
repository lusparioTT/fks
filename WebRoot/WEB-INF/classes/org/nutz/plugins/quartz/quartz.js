var ioc = {
   "scheduler" :{
      "type" :"org.quartz.Scheduler",
      "factory" :"org.quartz.impl.StdSchedulerFactory#getDefaultScheduler",
      "events" :{
         "create" :"start",
         "depose" :"shutdown"
      },
      "fields" :{
         "jobFactory" :{
            "refer" :"jobFactory"
         }
      }
   },
   "jobFactory" :{
      "type" :"org.nutz.plugins.quartz.NutQuartzJobFactory",
      "args" :[{
         "refer" :"$ioc"
      }]
   },
   "nutQuartzCronJobFactory" :{
      "type" :"org.nutz.plugins.quartz.NutQuartzCronJobFactory",
      "events" :{
         "create" :"init"
      },
      "fields" :{
         "scheduler" :{
            "refer" :"scheduler"
         },
         "conf" :{
            "refer" :"config"
         }
      }
   }
};