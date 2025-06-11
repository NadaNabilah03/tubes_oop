// Authentication and page protection
function checkAuth() {
  if (!localStorage.getItem('isLoggedIn')) {
    window.location.href = 'login.html';
    return false;
  }
  return true;
}

function logout() {
  localStorage.removeItem('isLoggedIn');
  localStorage.removeItem('userEmail');
  window.location.href = 'login.html';
}

// Mobile menu functionality
function toggleMobileMenu() {
  const nav = document.getElementById('mobileNav');
  const toggle = document.querySelector('.mobile-menu-toggle');
  
  nav.classList.toggle('active');
  toggle.classList.toggle('active');
}

// Initialize mobile menu functionality
document.addEventListener('DOMContentLoaded', function() {
  // Close mobile menu when clicking on a link
  document.querySelectorAll('nav a').forEach(link => {
    link.addEventListener('click', (e) => {
      // Check if it's logout link
      if (link.getAttribute('href') === 'login.html' && link.textContent.trim() === 'Logout') {
        e.preventDefault();
        logout();
        return;
      }
      
      const nav = document.getElementById('mobileNav');
      const toggle = document.querySelector('.mobile-menu-toggle');
      nav.classList.remove('active');
      toggle.classList.remove('active');
    });
  });

  // Close mobile menu when clicking outside
  document.addEventListener('click', (e) => {
    const nav = document.getElementById('mobileNav');
    const toggle = document.querySelector('.mobile-menu-toggle');
    const header = document.querySelector('header');
    
    if (!header.contains(e.target)) {
      nav.classList.remove('active');
      toggle.classList.remove('active');
    }
  });
}); 