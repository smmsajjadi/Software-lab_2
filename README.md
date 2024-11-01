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
  کلاس EmailMessageService هم مسئول ارسال پیام‌های مختلف (SMS، ایمیل و تلگرام) است و هم مسئولیت اعتبارسنجی آدرس ایمیل.
   کلاس Main هم مسئولیت مدیریت ورودی کاربر (خواندن ورودی و پردازش آن) و هم مسئولیت ارسال پیام‌ها را بر عهده دارد. 
 رابط (MessageService) برای ارسال انواع مختلف پیام‌ها (SMS، ایمیل و تلگرام) طراحی شده است. 
 کلاس SmsMessageService مسئولیت ارسال پیام‌های SMS را دارد، اما همچنین باید برای سایر انواع پیام‌ها (ایمیل و تلگرام) نیز متدهایی را پیاده‌سازی کند. 
 کلاس مTelegramMessageService نه تنها وظیفه ارسال پیام تلگرام را دارد، بلکه همچنین وظیفه اعتبارسنجی IDها را نیز بر عهده دارد.

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
  کلاس EmailMessageService هم مسئول ارسال پیام‌های مختلف (SMS، ایمیل و تلگرام) است و هم مسئولیت اعتبارسنجی آدرس ایمیل.
   کلاس Main هم مسئولیت مدیریت ورودی کاربر (خواندن ورودی و پردازش آن) و هم مسئولیت ارسال پیام‌ها را بر عهده دارد. 
 رابط (MessageService) برای ارسال انواع مختلف پیام‌ها (SMS، ایمیل و تلگرام) طراحی شده است. 
 کلاس SmsMessageService مسئولیت ارسال پیام‌های SMS را دارد، اما همچنین باید برای سایر انواع پیام‌ها (ایمیل و تلگرام) نیز متدهایی را پیاده‌سازی کند. 
 کلاس مTelegramMessageService نه تنها وظیفه ارسال پیام تلگرام را دارد، بلکه همچنین وظیفه اعتبارسنجی IDها را نیز بر عهده دارد.

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
  کلاس EmailMessageService هم مسئول ارسال پیام‌های مختلف (SMS، ایمیل و تلگرام) است و هم مسئولیت اعتبارسنجی آدرس ایمیل.
   کلاس Main هم مسئولیت مدیریت ورودی کاربر (خواندن ورودی و پردازش آن) و هم مسئولیت ارسال پیام‌ها را بر عهده دارد. 
 رابط (MessageService) برای ارسال انواع مختلف پیام‌ها (SMS، ایمیل و تلگرام) طراحی شده است. 
 کلاس SmsMessageService مسئولیت ارسال پیام‌های SMS را دارد، اما همچنین باید برای سایر انواع پیام‌ها (ایمیل و تلگرام) نیز متدهایی را پیاده‌سازی کند. 
 کلاس مTelegramMessageService نه تنها وظیفه ارسال پیام تلگرام را دارد، بلکه همچنین وظیفه اعتبارسنجی IDها را نیز بر عهده دارد.

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
  کلاس EmailMessageService هم مسئول ارسال پیام‌های مختلف (SMS، ایمیل و تلگرام) است و هم مسئولیت اعتبارسنجی آدرس ایمیل.
   کلاس Main هم مسئولیت مدیریت ورودی کاربر (خواندن ورودی و پردازش آن) و هم مسئولیت ارسال پیام‌ها را بر عهده دارد. 
 رابط (MessageService) برای ارسال انواع مختلف پیام‌ها (SMS، ایمیل و تلگرام) طراحی شده است. 
 کلاس SmsMessageService مسئولیت ارسال پیام‌های SMS را دارد، اما همچنین باید برای سایر انواع پیام‌ها (ایمیل و تلگرام) نیز متدهایی را پیاده‌سازی کند. 
 کلاس مTelegramMessageService نه تنها وظیفه ارسال پیام تلگرام را دارد، بلکه همچنین وظیفه اعتبارسنجی IDها را نیز بر عهده دارد.

</p>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>واسط MessageService این اصل را نقض میکند زیرا توابعی در آن تعریف شده اند که در همه ی کلاس هایی که آن را implement میکنند کاربرد ندارند.</p>
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
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>

## پاسخ پرسش ها
۲.
- کاهش وابستگی ها به صورتی که بتوان یک بلوک کد را بدون تاثیر بر سایر بلوک های کد تغغیر داد.
- طراحی آسان تر، قابلیت نگهداری، قابلیت آزمایش، مقیاس پذیری و قابلیت استفاده مجدد سیستم.
- آسان شدن ادغام اشیاء جدید.
