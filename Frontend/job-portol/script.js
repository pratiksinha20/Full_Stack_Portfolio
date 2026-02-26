

document.addEventListener('DOMContentLoaded', () => {

  // --- Element References ---
  const searchInput = document.getElementById('searchInput');
  const jobTableBody = document.getElementById('jobTableBody');
  const jobCountBadge = document.getElementById('jobCountBadge');
  const noResults = document.getElementById('noResults');

  const addJobBtn = document.getElementById('addJobBtn');
  const newJobId = document.getElementById('newJobId');
  const newJobRole = document.getElementById('newJobRole');
  const newJobLocation = document.getElementById('newJobLocation');
  const newJobType = document.getElementById('newJobType');

  const applyForm = document.getElementById('applyForm');
  const applySubmitBtn = document.getElementById('applySubmitBtn');
  const formCount = document.getElementById('count');

  let submitCount = 0;
  //  1. Job Count — keeps badge in sync

  function updateJobCount() {
    const visibleRows = jobTableBody.querySelectorAll('tr');
    const total = visibleRows.length;
    jobCountBadge.textContent = total + (total === 1 ? ' Job' : ' Jobs');
  }

  //  2. Search Functionality
  searchInput.addEventListener('input', () => {
    const query = searchInput.value.toLowerCase().trim();
    const rows = jobTableBody.querySelectorAll('tr');
    let matchCount = 0;

    rows.forEach(row => {
      const text = row.textContent.toLowerCase();
      if (text.includes(query)) {
        row.style.display = '';
        matchCount++;
      } else {
        row.style.display = 'none';
      }
    });

    noResults.style.display = matchCount === 0 ? 'block' : 'none';
  });

  //  3. Add Job Dynamically
  addJobBtn.addEventListener('click', () => {
    const id = newJobId.value.trim();
    const role = newJobRole.value.trim();
    const loc = newJobLocation.value.trim();
    const type = newJobType.value;

    // Validate all add-job fields
    let valid = true;
    [newJobId, newJobRole, newJobLocation, newJobType].forEach(el => {
      if (!el.value.trim()) {
        el.style.borderColor = '#ef4444';
        el.style.boxShadow = '0 0 0 3px rgba(239,68,68,0.2)';
        valid = false;
      } else {
        el.style.borderColor = '';
        el.style.boxShadow = '';
      }
    });

    if (!valid) return;

    // Determine badge class
    const typeMap = {
      'Full Time': 'badge-fulltime',
      'Part Time': 'badge-parttime',
      'Internship': 'badge-internship',
      'Remote': 'badge-remote'
    };
    const badgeClass = typeMap[type] || 'badge-fulltime';

    // Build new row
    const tr = document.createElement('tr');
    tr.innerHTML = `
            <td>${escapeHTML(id)}</td>
            <td>${escapeHTML(role)}</td>
            <td>${escapeHTML(loc)}</td>
            <td><span class="badge ${badgeClass}">${escapeHTML(type)}</span></td>
            <td><button class="btn btn-delete" title="Delete Job">✕</button></td>
        `;

    // Fade-in animation
    tr.style.opacity = '0';
    tr.style.transform = 'translateY(-8px)';
    jobTableBody.appendChild(tr);

    requestAnimationFrame(() => {
      tr.style.transition = 'opacity 0.4s ease, transform 0.4s ease';
      tr.style.opacity = '1';
      tr.style.transform = 'translateY(0)';
    });

    // Clear inputs
    newJobId.value = '';
    newJobRole.value = '';
    newJobLocation.value = '';
    newJobType.value = '';

    updateJobCount();
  });

  //  4. Delete Job (event delegation)
  jobTableBody.addEventListener('click', (e) => {
    const deleteBtn = e.target.closest('.btn-delete');
    if (!deleteBtn) return;

    const row = deleteBtn.closest('tr');
    row.style.transition = 'opacity 0.3s ease, transform 0.3s ease';
    row.style.opacity = '0';
    row.style.transform = 'translateX(30px)';

    setTimeout(() => {
      row.remove();
      updateJobCount();
    }, 300);
  });

  //  5. Application Form — Validation & One-Time Apply
  applyForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const fields = [
      { el: document.getElementById('nameInput'), name: 'Name' },
      { el: document.getElementById('emailInput'), name: 'Email' },
      { el: document.getElementById('qualInput'), name: 'Qualification' },
      { el: document.getElementById('jobIdInput'), name: 'Job ID' },
      { el: document.getElementById('skillsInput'), name: 'Skills' }
    ];

    let allValid = true;
    const errors = [];

    fields.forEach(({ el, name }) => {
      const val = el.value.trim();
      el.classList.remove('input-error');

      if (!val) {
        el.classList.add('input-error');
        errors.push(`${name} is required`);
        allValid = false;
      }
    });

    // Email format check
    const emailInput = document.getElementById('emailInput');
    const emailVal = emailInput.value.trim();
    if (emailVal && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailVal)) {
      emailInput.classList.add('input-error');
      errors.push('Please enter a valid email address');
      allValid = false;
    }

    if (!allValid) {
      showToast('⚠️ ' + errors[0], 'error');
      return;
    }

    // Success — update count
    submitCount++;
    formCount.textContent = submitCount;

    // One-time apply: disable button
    applySubmitBtn.disabled = true;
    applySubmitBtn.textContent = '✅ Applied Successfully';

    showToast('🎉 Application submitted successfully!', 'success');
  });

  // Reset button re-enables apply
  applyForm.addEventListener('reset', () => {
    setTimeout(() => {
      applySubmitBtn.disabled = false;
      applySubmitBtn.textContent = '🚀 Apply Now';
      // Clear error styles
      applyForm.querySelectorAll('.input-error').forEach(el => el.classList.remove('input-error'));
    }, 10);
  });

  //  6. Toast Notification
  function showToast(message, type = 'success') {
    const existing = document.querySelector('.toast-notification');
    if (existing) existing.remove();

    const toast = document.createElement('div');
    toast.className = 'toast-notification';
    toast.textContent = message;

    const bg = type === 'success'
      ? 'linear-gradient(135deg, #22c55e, #16a34a)'
      : 'linear-gradient(135deg, #ef4444, #dc2626)';

    Object.assign(toast.style, {
      position: 'fixed',
      bottom: '30px',
      right: '30px',
      padding: '14px 28px',
      background: bg,
      color: '#fff',
      borderRadius: '12px',
      fontFamily: 'Inter, sans-serif',
      fontWeight: '600',
      fontSize: '0.9rem',
      boxShadow: '0 8px 32px rgba(0,0,0,0.3)',
      zIndex: '9999',
      opacity: '0',
      transform: 'translateY(20px)',
      transition: 'opacity 0.4s ease, transform 0.4s ease'
    });

    document.body.appendChild(toast);

    requestAnimationFrame(() => {
      toast.style.opacity = '1';
      toast.style.transform = 'translateY(0)';
    });

    setTimeout(() => {
      toast.style.opacity = '0';
      toast.style.transform = 'translateY(20px)';
      setTimeout(() => toast.remove(), 400);
    }, 3000);
  }

  //  Helper: Escape HTML to prevent injection

  function escapeHTML(str) {
    const div = document.createElement('div');
    div.textContent = str;
    return div.innerHTML;
  }

  // --- Init ---
  updateJobCount();
});
