import pytest
from playwright.sync_api import sync_playwright

def test_valid_login():
    with sync_playwright() as p:
        browser = p.chromium.launch(headless=True)
        page = browser.new_page()
        page.goto("https://example.com/login")

        page.fill("#username", "admin")
        page.fill("#password", "password")
        page.click("#login")

        assert "Dashboard" in page.title()
        browser.close()

