@Service
public class AnalystServiceImpl implements AnalystService {

    private final AnalystRepository analystRepository;
    private final IssueRepository issueRepository;

    public AnalystServiceImpl(AnalystRepository analystRepository,
                              IssueRepository issueRepository) {
        this.analystRepository = analystRepository;
        this.issueRepository = issueRepository;
    }

    // 🔐 Login
    @Override
    public Analyst verifyAnalystLogin(String email, String pwd) {
        return analystRepository.findByEmailAndPassword(email, pwd);
    }

    // 📋 View all issues
    @Override
    public List<Issue> viewAllIssues() {
        return issueRepository.findAll();
    }

    // ⚠️ View only pending problems
    @Override
    public List<Issue> viewAllProblems() {
        return issueRepository.findByStatus("PENDING");
    }

    // ✅ Solve issue
    @Override
    public Issue solveIssue(Long id) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue with ID " + id + " not found"));

        issue.setStatus("SOLVED");
        return issueRepository.save(issue);
    }
}
