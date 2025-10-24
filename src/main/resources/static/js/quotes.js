(function () {
    function $(sel) { return document.querySelector(sel); }

    document.addEventListener("DOMContentLoaded", function () {
        const btn     = $("#js-new-quote");
        const textEl  = $("#js-quote-text");
        const authorEl= $("#js-quote-author");
        if (!btn || !textEl) return; // this page doesn't have the quote UI

        const provider = btn.getAttribute("data-provider") || "stoic";
        const url = `/api/quotes/${provider}/random`;

        btn.addEventListener("click", async () => {
            const original = btn.textContent;
            btn.disabled = true;
            btn.textContent = "Loading…";

            try {
                const res = await fetch(url, { headers: { "Accept": "application/json" }});
                if (!res.ok) throw new Error(`HTTP ${res.status}`);
                const data = await res.json();

                textEl.textContent = data.text || "No quote received.";
                if (authorEl) {
                    if (data.author) {
                        authorEl.textContent = data.author;
                        authorEl.parentElement.style.display = ""; // show footer
                    } else {
                        authorEl.parentElement.style.display = "none"; // hide footer if no author
                    }
                }
            } catch (e) {
                console.error(e);
                textEl.textContent = "Sorry—couldn’t fetch a new quote.";
                if (authorEl) authorEl.parentElement.style.display = "none";
            } finally {
                btn.disabled = false;
                btn.textContent = original;
            }
        });
    });
})();
