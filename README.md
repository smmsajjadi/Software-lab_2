# Software-lab_2
## تغییرات اعمال شده در مرحله اول
<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>EmailMessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage با بدنه خالی</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>SmsMessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage با بدنه خالی</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>افزودن کلاس سرویس پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک کلاس public با عنوان TelegramMessageService که واسط MessageService را implement میکند و دارای توابعی برای ارسال پیام تلگرامی و صحت سنجی آیدی است و همچنین توابع sendSmsMessage و sendEmailMessage با بدنه خالی است</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>افزودن کلاس پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک کلاس public با عنوان TelegramMessage که کلاس Message را extend میکند و دارای متغیر های آیدی مبدا و مقصد به صورت String و توابعی برای get‌ یا set کردن آن هاست</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۶</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>افزودن قابلیت ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن حالت ارسال پیام تلگرامی با وارد کردن عدد ۳ و اضافه کردن کد لازم برای ارسال پیام تلگرامی با استفاده از کلاس های تعریف شده</p>
</td>
</tr>
</tbody>
</table>

## بررسی تحقق یا عدم تحقق اصول SOLID
<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>توابع validate‌ این اصل را رعایت میکنند زیرا فقط وظیفه احراز درستی آیدی یا شماره تلفن را دارند.
همچنین توابع send...Message فقط توابع validate‌را صدا میزنند و در صورت درست بودن شرایط پیام را ارسال میکنند وگرنه خطا میدهند. 
کلاس Message تنها یک مسئولیت دارد و آن هم مدیریت محتوای پیام است..
در EmailMessage  این اصل رعایت میشود.
 کلاس SmsMessage تنها مسئولیت مدیریت اطلاعات مربوط به یک پیام SMS را دارد. 
 TelegramMessage تنها مسئولیت نگهداری اطلاعات مربوط به پیام تلگرام (مانند sourceID و targetID) را دارد.

</p>
  
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td width="454">
<p>
  کلاس EmailMessageService هم مسئول ارسال پیام‌های مختلف (SMS، ایمیل و تلگرام) است و هم مسئولیت اعتبارسنجی آدرس ایمیل.
   کلاس Main هم مسئولیت مدیریت ورودی کاربر (خواندن ورودی و پردازش آن) و هم مسئولیت ارسال پیام‌ها را بر عهده دارد. 
 رابط (MessageService) برای ارسال انواع مختلف پیام‌ها (SMS، ایمیل و تلگرام) طراحی شده است. 
 کلاس SmsMessageService مسئولیت ارسال پیام‌های SMS را دارد، اما همچنین باید برای سایر انواع پیام‌ها (ایمیل و تلگرام) نیز متدهایی را پیاده‌سازی کند. 
 کلاس مTelegramMessageService نه تنها وظیفه ارسال پیام تلگرام را دارد، بلکه همچنین وظیفه اعتبارسنجی IDها را نیز بر عهده دارد.

</p>
  
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
 <p>
     • اگر بخواهیم نوع جدیدی از پیام‌ها اضافه کنیم، می‌توانیم کلاس‌های جدیدی ایجاد کنیم که از Message ارث‌بری کنند. بنابراین، این اصل دراین کلاس رعایت شده است.
      کلاس Message به گونه‌ای طراحی شده که می‌توان آن را بدون نیاز به تغییر کد موجود گسترش داد.
      . اگر بخواهید نوع جدیدی از پیام ایجاد کنید، می‌توانید کلاس‌های جدیدی بسازید بدون اینکه نیازی به تغییر در کلاس TelegramMessageو SmsMessage باشد.
      
     

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
 <p>
  باید کلاس EmailMessageService را تغییر دهید تا متد جدیدی برای ارسال آن پیام اضافه شود.
   باید کد در کلاس Main را تغییر دهید تا نوع جدید پیام را مدیریت کند. 
    اگر بخواهیم نوع جدیدی از پیام اضافه کنیم، باید رابط MessageService تغییر کند. همچنین کلاس SmsMessageService و TelegramMessageService 

    

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
 <p>
  موارد تحقق در کلاس های:
اگر SmsMessage از یک کلاس پایه (مثل Message) ارث‌بری کند، می‌توان آن را جایگزین هر جایی که نوع پایه استفاده شده است، کرد. بنابراین، این اصل رعایت شده است.
TelegramMessageService 
 TelegramMessage 
 SmsMessageService 
SmsMessage 
Message
Main
EmailMessageService
EmailMessage

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>کلاس های ...MessageService این اصل را نقض میکنند زیرا متد های نامرتبط در آن ها با بدنه ی خالی وجود دارد</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
 <p>
 

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>واسط MessageService این اصل را نقض میکند زیرا توابعی در آن تعریف شده اند که در همه ی کلاس هایی که آن را implement میکنند کاربرد ندارند.
  کلاس TelegramMessageService تمام متدهای تعریف شده در MessageService را پیاده‌سازی کرده است، مکن است برای این کلاس کاربردی نداشته باشند. این نقض ISP است زیرا این کلاس به متدهای غیرضروری وابسته است.

</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
 <p>
 TelegramMessageService
TelegramMessage
SmsMessageService
SmsMessage
MessageService
Message
EmailMessageService

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
 <p>
  کلاس Main به جزئیات پیاده‌سازی‌های خاص (SmsMessageService، EmailMessageService و TelegramMessageService) وابسته است. این نشان می‌دهد که کد به جزئیات وابسته است و این اصل نقض شده 


</p>
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>




در خصوص هرکدام از موارد نقض هرکدام از اصول، یک راهکار را به منظور رفع آن مشکل ارایه داده و در جدول زیر ثبت نمایید:

<table dir='rtl'>
<tbody>
<tr>
<td width="168">
<p><strong>اصل مربوطه (از اصول </strong><strong>SOLID</strong><strong>)</strong></p>
</td>
<td width="246">
<p><strong>علت نقض</strong></p>
</td>
<td width="284">
<p><strong>راه حل پیشنهادی</strong></p>
</td>
</tr>
<tr>
<td width="168">
 <p> 
 Single Responsibility Principle (SRP)
</p> 
<p>&nbsp;</p>
</td>
<td width="246">
 کلاس‌های EmailMessageService، SmsMessageService و TelegramMessageService وظایف متعددی دارند: ارسال پیام و اعتبارسنجی آدرس/شماره تلفن.
<p>&nbsp;</p>
</td>
<td width="284">
 منطق validation را از کلاس های سرویس پیام جدا کنیم.
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
 <p> 
Open-Close Principle (OCP)
</p> 
<p>&nbsp;</p>
</td>
<td width="246">
 رابط MessageService برای تغییر بسته نیست. هر بار که یک نوع پیام جدید اضافه می شود، رابط و پیاده سازی آن باید تغییر کنند.
<p>&nbsp;</p>
</td>
<td width="284">
 از رابط های جداگانه برای هر نوع سرویس پیام میتوانیم استفاده کنیم.
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
 <p> 
Liskov Substitution Principle
</p> 
<p>&nbsp;</p>
</td>
<td width="246">
<p>&nbsp;</p>
</td>
<td width="284">
 
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td width="168">
 <p> 
Interface Segregation Principle</p> 
<p>&nbsp;</p>
</td>
<td width="246">
 رابط MessageService همه پیاده‌سازی‌ها را مجبور می‌کند تا قالب هایی را که برای همه نوع پیام‌ها که حتی از آن‌ها استفاده نمی‌کنند نیز تعریف کنند (به عنوان مثال sendSmsMessage در EmailMessageService).
<p>&nbsp;</p>
</td>
<td width="284">
 رابط MessageService را برای هر نوع پیام به اینترفیس های کوچکتر و خاص تر تقسیم میکنیم.
<p>&nbsp;</p>
</td>
</tr>
 <tr>
<td width="168">
 <p> 
Dependency Inversion Principle
 </p> 
<p>&nbsp;</p>
</td>
<td width="246">
  کلاس Main مستقیماً پیاده سازی های سرویس پیام خاص را نشان می دهد 

<p>&nbsp;</p>
</td>
<td width="284">

 <p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>

### گام ۳: اصلاح موارد نقض
در نهایت، بر اساس تحلیلی که انجام داده‌اید و راه حل‌هایی که در بخش قبل ارایه کردید، کد را اصلاح کرده و بر روی مخزن گیت‌هاب و در پوشه‌ای مجزا از گام قبل commit و push کنید. انتظار می‌رود که تمامی راه حل‌های پیشنهادی خود را بر روی این نسخه اعمال کنید و تمامی بهبودهایی که انجام می‌دهید، در جداول بخش قبل موجود باشد.

### گام ۴: بررسی مجدد تغییرات مورد نیاز
فرض کنید که گام 1 را برای کد اصلاح شده (پس از انجام گام‌های ۲ و ۳) اجرا کرده‌اید.
1. در این صورت از انجام کدام یک از تغییرات ثبت شده در جدول گام ۱ معاف خواهید شد؟
2. تعداد تغییرات مورد نیاز، چند تغییر خواهد شد؟

### گام ۵: جمع بندی
در این بخش، بیان کنید که از این گام چه نتیجه‌ای گرفته‌اید؟ و به نظر شما به کارگیری صحیح اصول SOLID در گام‌های ۳ و ۴ چه مزایایی را نسبت به حالتی دارد که این اصول رعایت نشده‌بود؟



## پاسخ پرسش ها
۲.
- کاهش وابستگی ها به صورتی که بتوان یک بلوک کد را بدون تاثیر بر سایر بلوک های کد تغغیر داد.
- طراحی آسان تر، قابلیت نگهداری، قابلیت آزمایش، مقیاس پذیری و قابلیت استفاده مجدد سیستم.
- آسان شدن ادغام اشیاء جدید.
