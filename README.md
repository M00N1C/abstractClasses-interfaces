<div dir="rtl" style="text-align: right;">

<h1>تسلط بر انتزاع در جاوا: کلاس‌های انتزاعی و اینترفیس‌ها ✨</h1>

<h2>معرفی</h2>
<p>در این راهنما، مفهوم <strong>انتزاع</strong> در جاوا را با توضیح روشن، مثال‌های آماده اجرا، و سه تمرین عملی یاد می‌گیرید تا فوراً تمرین کنید. 🚀</p>

<hr />

<h2>بخش ۱: درسنامه (با مثال)</h2>
<p>انتزاع یعنی پنهان کردن جزئیات پیچیده و نشان دادن فقط چیزهای ضروری. در جاوا این کار را با <strong>کلاس‌های انتزاعی</strong> و <strong>اینترفیس‌ها</strong> انجام می‌دهیم.</p>

<h3>کلاس‌های انتزاعی: هویت مشترک و پیاده‌سازی جزئی 🏗️</h3>
<ul>
  <li>با <code>abstract</code> تعریف می‌شوند و <strong>مستقیم قابل نمونه‌سازی نیستند</strong>.</li>
  <li>می‌توانند <strong>حالت (state)</strong>، <strong>سازنده</strong> و هم <strong>متد انتزاعی</strong> و هم <strong>متد پیاده‌سازی‌شده</strong> داشته باشند.</li>
  <li>برای رابطه‌ی محکم <strong>is-a</strong> مناسب‌اند؛ فرزندان داده/رفتار مشترک دارند ولی جزئیات را خودشان کامل می‌کنند.</li>
</ul>

<p><strong>مثال: نقشه‌ی کلی یک وسیله‌ی نقلیه با متد قالب (template)</strong></p>
</div>

<div dir="ltr" style="text-align: left;">

```java
public abstract class Vehicle {
    private final String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void startEngine() {
        System.out.println(brand + " engine started");
    }

    // هر وسیله الگوریتم برد را خودش تعریف می‌کند.
    public abstract double calculateRange();

    // متد قالب: جریان مشترک با یک گام قابل سفارشی‌سازی.
    public final void tripReport(double distanceKm) {
        System.out.println("Trip distance: " + distanceKm + " km");
        System.out.println("Estimated range left: " + (calculateRange() - distanceKm));
    }
}

public class ElectricCar extends Vehicle {
    private final double batteryKWh;
    private final double efficiencyKmPerKWh;

    public ElectricCar(String brand, double batteryKWh, double efficiencyKmPerKWh) {
        super(brand);
        this.batteryKWh = batteryKWh;
        this.efficiencyKmPerKWh = efficiencyKmPerKWh;
    }

    @Override
    public double calculateRange() {
        return batteryKWh * efficiencyKmPerKWh;
    }
}
```
</div>

<div dir="rtl" style="text-align: right;">

<p>اینجا کلاس انتزاعی، حالت (<code>brand</code>) و جریان مشترک (<code>tripReport</code>) را می‌دهد و فرزندان مجبورند <code>calculateRange()</code> را تعریف کنند.</p>

<h3>اینترفیس‌ها: قرارداد قابلیت‌ها 🤝</h3>
<ul>
  <li>با <code>interface</code> تعریف می‌شوند؛ نشان می‌دهند <strong>یک نوع چه کاری می‌تواند انجام دهد</strong> نه این‌که «چی هست».</li>
  <li>حالت نگه نمی‌دارند؛ فیلدها ثابت‌اند. کلاس می‌تواند <strong>چند اینترفیس</strong> را هم‌زمان پیاده کند.</li>
  <li>برای کلاس‌های <strong>نامرتبط</strong> با قابلیت مشترک عالی‌اند (رابطه‌ی can-do).</li>
</ul>

<p><strong>مثال: قرارداد ساده‌ی پخش رسانه با متد پیش‌فرض</strong></p>
</div>

<div dir="ltr" style="text-align: left;">

```java
public interface Playable {
    void play();
    void stop();

    // متد پیش‌فرض از جاوا 8: رفتار مشترک اختیاری.
    default void restart() {
        stop();
        play();
    }
}

public class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing audio file...");
    }

    @Override
    public void stop() {
        System.out.println("Audio stopped.");
    }
}

public class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Rendering video frames...");
    }

    @Override
    public void stop() {
        System.out.println("Video paused.");
    }
}
```
</div>

<div dir="rtl" style="text-align: right;">

<p>هر دو کلاس به قرارداد پایبندند و می‌توانند از طریق <code>Playable</code> به‌صورت چندریختی مدیریت شوند.</p>

<h3>کلاس انتزاعی در برابر اینترفیس، در یک نگاه 📌</h3>

<table dir="rtl" style="text-align: right;">
  <thead>
    <tr>
      <th>ویژگی</th>
      <th>کلاس انتزاعی</th>
      <th>اینترفیس</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>هدف</strong></td>
      <td>اشتراک کد و حالت برای انواع مرتبط</td>
      <td>تعریف یک قابلیت برای هر نوع</td>
    </tr>
    <tr>
      <td><strong>حالت</strong></td>
      <td>مجاز (فیلد و سازنده)</td>
      <td>مجاز نیست (فقط ثابت)</td>
    </tr>
    <tr>
      <td><strong>متدها</strong></td>
      <td>انتزاعی + پیاده‌شده</td>
      <td>انتزاعی + <code>default</code>/<code>static</code></td>
    </tr>
    <tr>
      <td><strong>وراثت</strong></td>
      <td>یک والد (extends)</td>
      <td>چند اینترفیس (implements)</td>
    </tr>
    <tr>
      <td><strong>زمان استفاده</strong></td>
      <td>رابطه‌ی قوی is-a با کد مشترک</td>
      <td>قابلیت مشترک در انواع نامرتبط</td>
    </tr>
  </tbody>
</table>

<h3>کار ترکیبی: وراثت + قابلیت 🎯</h3>
<p>رایج است که از یک پایه‌ی انتزاعی ارث ببرید و برای ویژگی‌های اختیاری چند اینترفیس اضافه کنید.</p>
</div>

<div dir="ltr" style="text-align: left;">

```java
public interface SecureTransaction {
    boolean authenticate();
}

public abstract class Payment {
    protected final double amount;

    protected Payment(double amount) {
        this.amount = amount;
    }

    public void logTransaction() {
        System.out.println("Logging amount: " + amount);
    }

    public abstract void process();
}

public class CreditCardPayment extends Payment implements SecureTransaction {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public boolean authenticate() {
        System.out.println("Authenticating card...");
        return true;
    }

    @Override
    public void process() {
        if (authenticate()) {
            logTransaction();
            System.out.println("Charging credit card: " + amount);
        }
    }
}

public class CashOnDelivery extends Payment {
    private final String address;

    public CashOnDelivery(double amount, String address) {
        super(amount);
        this.address = address;
    }

    @Override
    public void process() {
        logTransaction();
        System.out.println("Collect cash at: " + address);
    }
}
```
</div>

<div dir="rtl" style="text-align: right;">

<p><code>Payment</code> داده و رفتار مشترک را فراهم می‌کند، و <code>SecureTransaction</code> فقط جایی اضافه می‌شود که نیاز به احراز هویت است.</p>

<h3>چک‌لیست تصمیم سریع ✅</h3>
<ul>
  <li>حالت/سازنده و جریان مشترک می‌خواهید؟ → <strong>کلاس انتزاعی</strong>.</li>
  <li>قابلیت مشترک در انواع نامرتبط می‌خواهید؟ → <strong>اینترفیس</strong>.</li>
  <li>هم جریان مشترک و هم قابلیت‌های اختیاری لازم است؟ → ترکیب: یک کلاس انتزاعی را extend کنید و یک یا چند اینترفیس را implement.</li>
</ul>

<hr />

<h2>بخش ۲: تمرین‌های کدنویسی 💻</h2>
<p>از این سناریوها برای تمرین استفاده کنید.</p>

<h3>تمرین ۱: معماری سیستم مدیریت کارمند (تمرکز روی کلاس انتزاعی)</h3>
<p><strong>سناریو:</strong> سیستم حقوق و دستمزد می‌سازید. همه‌ی کارمندها ویژگی‌های مشترک دارند، اما محاسبه‌ی حقوق بسته به نوع قرارداد متفاوت است.</p>
<p><strong>کارها:</strong></p>
<ol>
  <li>کلاس انتزاعی <code>Employee</code> بسازید:
    <ul>
      <li>فیلدهای protected: <code>name</code> و <code>id</code></li>
      <li>سازنده برای مقداردهی</li>
      <li>متد پیاده‌شده <code>displayInfo()</code> برای چاپ نام و شناسه</li>
      <li>متد انتزاعی <code>calculateSalary()</code></li>
    </ul>
  </li>
  <li>کلاس <code>FullTimeEmployee</code> که <code>Employee</code> را extend می‌کند:
    <ul>
      <li>فیلد <code>monthlySalary</code></li>
      <li><code>calculateSalary()</code> را طوری پیاده کند که همان حقوق ثابت را برگرداند</li>
    </ul>
  </li>
  <li>کلاس <code>HourlyEmployee</code> که <code>Employee</code> را extend می‌کند:
    <ul>
      <li>فیلدهای <code>hourlyRate</code> و <code>hoursWorked</code></li>
      <li><code>calculateSalary()</code> را طوری پیاده کند که <code>hourlyRate * hoursWorked</code> را برگرداند</li>
    </ul>
  </li>
</ol>
<p><strong>هدف آموزشی:</strong> تشخیص کد مشترک (مثل ذخیره‌سازی نام و چاپ اطلاعات) در والد، و منطق تخصصی (محاسبه‌ی حقوق) در فرزند.</p>

<h3>تمرین ۲: سیستم پخش رسانه (تمرکز روی اینترفیس)</h3>
<p><strong>سناریو:</strong> پخش‌کننده‌ای می‌خواهید که هم صوت و هم ویدیو را پشتیبانی کند. این کلاس‌ها متفاوت‌اند، اما قابلیت «قابل‌پخش بودن» را مشترک دارند.</p>
<p><strong>کارها:</strong></p>
<ol>
  <li>اینترفیس <code>Playable</code> بسازید با:
    <ul>
      <li>متد <code>play()</code></li>
      <li>متد <code>stop()</code></li>
    </ul>
  </li>
  <li>کلاس <code>MusicPlayer</code> که <code>Playable</code> را پیاده می‌کند:
    <ul>
      <li>در <code>play()</code> چاپ کند: <code>"Playing audio file..."</code></li>
    </ul>
  </li>
  <li>کلاس <code>VideoPlayer</code> که <code>Playable</code> را پیاده می‌کند:
    <ul>
      <li>در <code>play()</code> چاپ کند: <code>"Rendering video pixels..."</code></li>
    </ul>
  </li>
  <li>در <code>Main</code>:
    <ul>
      <li>یک <code>ArrayList&lt;Playable&gt;</code> بسازید</li>
      <li>یک پخش‌کننده‌ی صوت و یک پخش‌کننده‌ی ویدیو به آن اضافه کنید</li>
      <li>با یک حلقه <code>for</code> روی همه <code>play()</code> را صدا بزنید</li>
    </ul>
  </li>
</ol>
<p><strong>هدف آموزشی:</strong> تمرین چندریختی از طریق اینترفیس. لیست نمی‌داند چه نوعی داخلش است؛ فقط به قرارداد <code>Playable</code> تکیه می‌کند.</p>

<h3>تمرین ۳: سیستم پرداخت فروشگاه آنلاین (ترکیبی)</h3>
<p><strong>سناریو:</strong> فروشگاه آنلاین چند روش پرداخت دارد. همه باید ثبت تراکنش داشته باشند، اما فقط بعضی‌ها نیاز به احراز هویت دارند.</p>
<p><strong>کارها:</strong></p>
<ol>
  <li>اینترفیس <code>SecureTransaction</code> بسازید با:
    <ul>
      <li>متد <code>authenticate()</code> که <code>boolean</code> برمی‌گرداند</li>
    </ul>
  </li>
  <li>کلاس انتزاعی <code>Payment</code> بسازید با:
    <ul>
      <li>فیلد <code>amount</code></li>
      <li>متد پیاده‌شده <code>logTransaction()</code> که تاریخ و مبلغ را چاپ کند</li>
      <li>متد انتزاعی <code>process()</code> برای اجرای پرداخت</li>
    </ul>
  </li>
  <li>کلاس <code>CreditCardPayment</code> که:
    <ul>
      <li><code>Payment</code> را extend می‌کند و <code>SecureTransaction</code> را پیاده می‌کند</li>
      <li>در <code>process()</code> ابتدا <code>authenticate()</code> را صدا بزند و اگر <code>true</code> بود پرداخت را انجام دهد</li>
    </ul>
  </li>
  <li>کلاس <code>CashOnDelivery</code> که:
    <ul>
      <li>فقط <code>Payment</code> را extend می‌کند (بدون امنیت)</li>
      <li>در <code>process()</code> آدرس تحویل را چاپ کند</li>
    </ul>
  </li>
</ol>
<p><strong>هدف آموزشی:</strong> تشخیص زمان استفاده از وراثت (داده/جریان مشترک) در برابر قابلیت (اینترفیس) و نحوه‌ی ترکیب تمیز آن‌ها.</p>

</div>
